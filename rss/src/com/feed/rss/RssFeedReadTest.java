package com.feed.rss;

import java.io.IOException;

import de.nava.informa.core.ParseException;
import de.nava.informa.impl.basic.Channel;
import de.nava.informa.impl.basic.ChannelBuilder;
import de.nava.informa.impl.basic.Item;
import de.nava.informa.parsers.FeedParser;

/**
 * Leitura de feeds via RSS com a API Informa
 * 
 */
public class RssFeedReadTest {

    public static void main( String[] args ) throws IOException, ParseException {
        ChannelBuilder builder =  new ChannelBuilder();

        String atomUrl = "http://portal-ibm.blogspot.com/feeds/posts/default";
        String xmlURL = "http://www.estadao.com.br/rss/nacional.xml";
        String rssUrl = "http://portal-ibm.blogspot.com/feeds/posts/default?alt=rss";
        
        //parseAndShow( builder, rssUrl );
        parseAndShow(builder, atomUrl );
        parseAndShow(builder, xmlURL);

    }

    private static void parseAndShow( ChannelBuilder builder, String url ) throws IOException, ParseException {
        Channel channel = (Channel) FeedParser.parse(builder, url);
        
        System.out.println("Titulo do canal: " + channel.getTitle());
        System.out.println("Descricao do canal: " + channel.getDescription());

        System.out.println("====================================");

        for (Object x : channel.getItems()) {
            Item anItem = (Item) x;
            System.out.print("[<<< Titulo Post: " + anItem.getTitle() + " >>>] ::: ");
            System.out.println("[<<< Conteudo Post: " + anItem.getDescription());
        }
    }

}
