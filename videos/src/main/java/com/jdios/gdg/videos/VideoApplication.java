package com.jdios.gdg.videos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Video microservice
 * @author jdotero
 *
 */
@SpringBootApplication
@ComponentScan
public class VideoApplication 
{
    public static void main( String[] args )
    {
    		SpringApplication.run(VideoApplication.class, args);
    }
}
