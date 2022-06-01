package com.panini.contract.api.panini;  
import java.util.ArrayList;
import java.util.List;

import com.panini.demo.controller.UsersREST;
import com.panini.demo.model.Album;
import com.panini.demo.services.AlbumService;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.*;
import au.com.dius.pact.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate; 
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@PactBroker(url = "${PACT_BROKER_BASE_URL}", authentication = @PactBrokerAuth(token = "${PACT_BROKER_TOKEN}") ) 
@Provider("AlbumPaniniBack") 
@ExtendWith(MockitoExtension.class)
public class PaniniTest {      
    @Mock private AlbumService albumService; 
    @InjectMocks private UsersREST usersREST;      
    @TestTemplate     
    @ExtendWith(PactVerificationInvocationContextProvider.class)     
    public void pactVerificationTestTemplate(PactVerificationContext context) {         
        context.verifyInteraction();     
    }      
    @BeforeEach 
    public void changeContext(PactVerificationContext context) { 
        System.setProperty("pact.verifier.publishResults","true");
        MockMvcTestTarget testTarget = new MockMvcTestTarget();     
        testTarget.setControllers(usersREST);     
        context.setTarget(testTarget); 
    }
    //Default list-albums
    @State("has albums") 
    public void listAlbums() {     
        Album album = new Album();     

        album.setAlbumid(112233);
        album.setAlbumName("Nuevo");
        album.setUserref("m4DbIGm7U2OB4Bmqew4nRKoiP7p2");
        album.setLaminasNumber(0);
        List<Album> albums = new ArrayList<Album>();     
        albums.add(album);     
        Mockito.when(albumService.getAllAlbums()).thenReturn(albums); 
    }
    //Get-album
    @State("has one specific album")
    public void getAlbum() {
        Album album = new Album();

        album.setAlbumid(112233);
        album.setAlbumName("Nuevo");
        album.setUserref("m4DbIGm7U2OB4Bmqew4nRKoiP7p2");
        album.setLaminasNumber(0);

        Mockito.when(albumService.findById(112233)).thenReturn(album);
    }
    //Delete-album
    @State("delete album")
    public void deleteAlbum() {
        Album album = new Album();

        album.setAlbumid(112233);
        album.setAlbumName("Nuevo");
        album.setUserref("m4DbIGm7U2OB4Bmqew4nRKoiP7p2");
        album.setLaminasNumber(0);

        albumService.delete(album);
    }
    //Post-album
    @State("post album")
    public void saveAlbum() {
        Album album = new Album();

        album.setAlbumid(112233);
        album.setAlbumName("Nuevo");
        album.setUserref("m4DbIGm7U2OB4Bmqew4nRKoiP7p2");
        album.setLaminasNumber(0);

        Mockito.when(albumService.create(album, "m4DbIGm7U2OB4Bmqew4nRKoiP7p2")).thenReturn(album);
    }
    //Put-animal
    @State("put album")
    public void updateAlbum() {
        Album album = new Album();

        album.setAlbumid(112233);
        album.setAlbumName("Nuevo");
        album.setUserref("m4DbIGm7U2OB4Bmqew4nRKoiP7p2");
        album.setLaminasNumber(0);


        Mockito.when(albumService.update(album, Long.parseLong("112233"))).thenReturn(album);
    }
} 