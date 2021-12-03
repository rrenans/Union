package com.union.qrcode;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class GerarQrCode {
	
	public static byte[] gerarQrCode() throws Exception {
        
		// URL para a qual o qr code será direcionado
        String content = "https://union-senai-app.herokuapp.com/#/detalhes/3";
        
        // URL para onde o qr code é gerado -> mudar depois
        String pathToStore = "QRCodeGenerated.jpg";
        
        // definir o formato, altura e largura do qr code, o tipo da imagem
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 500, 500);
        MatrixToImageWriter.writeToPath(bitMatrix, "jpg", Paths.get(pathToStore));
        
        // dando tudo certo, roda isso no console
        System.out.println("QR Code Generated Successfully");
        
        return Files.readAllBytes(Paths.get(pathToStore));
        
    }
	
}
