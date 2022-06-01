package com.panini.components;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panini.demo.model.Album;
import com.panini.demo.model.User;
import com.panini.demo.repository.AlbumRepository;
import com.panini.demo.repository.UsersResporitory;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import lombok.SneakyThrows;
import lombok.var;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"spring.config.additional-location=classpath:component-test.yml" })
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GetAlbumTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    UsersResporitory userRepository;

    String userid;

    @BeforeEach
    public void setUp() {
        User user = new User();

        Album album = new Album(1235478, "Birmano");
        user.setUserid("usuario1");
        user.setUsername("usuario1");
        user.addAlbum(album);
        album.setUserref(user.getUserid());
        userRepository.save(user);
        albumRepository.save(album);

        userid = user.getUserid();

    }

    @Test
    @SneakyThrows
    public void albumsWithSuccessStatusCode() throws Exception {
    	
        var response = (var) mockMvc.perform(get("/api/users/usuario1/albums/11824")).andReturn().getResponse();

        assertThat(((MockHttpServletResponse) response).getStatus(), equalTo(HttpStatus.OK.value()));
        assertThat(((MockHttpServletResponse) response).getContentType(), equalTo(MediaType.APPLICATION_JSON.toString()));
    	
    }
    
    @Test
    @SneakyThrows
    public void detailedAlbumWithSuccessStatusCode() throws Exception {
    	var response = (var) mockMvc.perform(get("/api/users/usuario1/albums/11824")).andReturn().getResponse();
    	Album album =  new ObjectMapper().readValue(((MockHttpServletResponse) response).getContentAsString(), Album.class);
    	
    	assertThat(album.getAlbumName(), equalTo("Birmano"));
    	assertThat(album.getAlbumid(), equalTo(11824));
    	assertThat(album.getUserref(), equalTo("usuario1"));
    }
    
    @Test
    @SneakyThrows
    public void listAlbums() throws Exception {
    	var response = (var) mockMvc.perform(get("/api/users/usuario1/albums/")).andReturn().getResponse();

        assertThat(((MockHttpServletResponse) response).getStatus(), equalTo(HttpStatus.OK.value()));
        assertThat(((MockHttpServletResponse) response).getContentType(), equalTo(MediaType.APPLICATION_JSON.toString()));
    }
    	
   
    @Test
    @SneakyThrows
    public void listAlbumsWithRIgthSchema() throws Exception {
    	var response = (var) mockMvc.perform(get("/api/users/usuario1/albums/")).andReturn().getResponse();
    	
    	var jsonSchema = (var) new JSONObject(new JSONTokener(GetAlbumTest.class.getResourceAsStream("/api/users/usuario1/albums.json")+""));
        var jsonArray = (var) new JSONArray(((MockHttpServletResponse) response).getContentAsString());

        var schema = (var) SchemaLoader.load((JSONObject) jsonSchema);
        ((Schema) schema).validate(jsonArray);
    	
    }
}
