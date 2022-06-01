package com.panini.components;

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

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
        "spring.config.additional-location=classpath:component-test.yml" })
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

        user.addAlbum(album);
        album.setUserref(user.getUserid());
        userRepository.save(user);
        albumRepository.save(album);

        userid = user.getUserid();

    }

    @Test
    @SneakyThrows
    public void animaDetailWithSuccessStatusCodeAndContentType() throws Exception {
        var response = (var) mockMvc.perform(get("/api/users/")).andReturn().getResponse();

        assertThat(((MockHttpServletResponse) response).getStatus(), equalTo(HttpStatus.OK.value()));
        assertThat(((MockHttpServletResponse) response).getContentType(), equalTo(MediaType.APPLICATION_JSON.toString()));
    }
}
