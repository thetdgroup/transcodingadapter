package com.thetdgroup;

import java.io.File;

public class Tester
{
	//
	public static void main(String[] args)
	{
	 String source = "/Users/ericdamphousse/tmp/bird.avi";
	 String target = "/Users/ericdamphousse/tmp/bird.flv";
	
		try
		{
			//
			Encoder encoder = new Encoder(new MyFFMPEGExecutableLocator());
			//MultimediaInfo info = encoder.getInfo(new File("/Users/ericdamphousse/tmp/bird.avi"));
			
			//
			String strings[] = encoder.getVideoEncoders();
			
			for(String abc : strings)
			{
			 System.out.println(abc);
			}
		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}
	}
	
	//
	void transcode(String input, String output) throws IllegalArgumentException, InputFormatException, EncoderException, Exception
	{
		File source = new File(input);
		File target = new File(output);
		
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(64000));
		audio.setChannels(new Integer(1));
		audio.setSamplingRate(new Integer(22050));
		
		VideoAttributes video = new VideoAttributes();
		video.setCodec("flv");
		video.setBitRate(new Integer(160000));
		video.setFrameRate(new Integer(15));
		video.setSize(new VideoSize(400, 300));
		
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("flv");
		attrs.setAudioAttributes(audio);
		attrs.setVideoAttributes(video);
		
		Encoder encoder = new Encoder();
		encoder.encode(source, target, attrs);
	}
}
