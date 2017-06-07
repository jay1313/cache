package com.cache.testCache;

import java.util.ArrayList;
import java.util.List;

import org.apache.jcs.JCS;
import com.cache.model.Album;

public class MusicStore {
	
	private JCS cache;
	
	public MusicStore(){
		
		try {
			
			//LOAD THE CACHE
			cache = JCS.getInstance("musicCache");
		
			
			//INITIALIZE THE CACHE
			//db call--selection get name lst
			// load the call with db data using lst.get("name")
			
			
			
			
			/*
			List lst = new ArrayList();
			
			for(int i=0;i<lst.size();i++)
			{
				
				cache.put(new Integer(i), new Album(lst.get(name));
			}
			*/
			
			
			
			
			cache.put(new Integer(2), new Album(2, "Pillar", "Fireproof" ) );
			cache.put(new Integer(3), new Album(3, "Audio Adrenaline", "Underdog") );
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public void addAlbum(Album album){
		
		try {
			
			cache.put(album.getId(), album);
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public Album getAlbum(Integer id){
		
		return (Album)cache.get(id);
	}
	
	
	
	public void removeAlbum(Integer id){
		
		try {
			cache.remove(id);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public static void main( String[] args )
    {
        MusicStore musicStore = new MusicStore();
        musicStore.addAlbum( new Album( 4, "The O.C. Supertones","Supertones Strike Back"));
        Album album = musicStore.getAlbum( 2 );
        System.out.println( "Album 1: " + album.toString() );
        album = musicStore.getAlbum( 4 );
        System.out.println( "Album 4: " + album );
        musicStore.removeAlbum( 4 );
        album = musicStore.getAlbum( 4 );
        System.out.println( "Album 4: " + album );
    }
	
	
	
}
