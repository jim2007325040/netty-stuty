package cn.keking.nio;

import io.netty.util.CharsetUtil;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NioTest2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("NioTest2.text");
        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);

        byteBuffer.flip();
        List<Byte> list = new ArrayList<>();
        while(byteBuffer.remaining()>0){
            Byte b = byteBuffer.get();
            list.add(b);
        }
        byte[] bytes = new byte[list.size()];

        for(int i =0; i<bytes.length; i++){
            bytes[i] = list.get(i);
        }

        String a = new String(bytes, Charset.forName("UTF-8"));
        System.out.println("character" + a );

        fileInputStream.close();
    }
}
