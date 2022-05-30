package com.panini.components;

import com.panini.demo.model.Album;
import com.panini.demo.model.User;
import com.panini.demo.repository.AlbumRepository;
import com.panini.demo.repository.UsersResporitory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import lombok.SneakyThrows;
import lombok.var;

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
    public void animaDetailWithSuccessStatusCodeAndContentType() {
        var response = mockMvc.perform(get("/animals/Thor")).andReturn().getResponse();

        assertThat(response.getStatus(), equalTo(HttpStatus.OK.value()));
        assertThat(response.getContentType(), equalTo(MediaType.APPLICATION_JSON.toString()));
    }
}
