package com.union.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.union.qrcode.GerarQrCode;

@RestController
@RequestMapping(path = "/qrcode")
@CrossOrigin(origins="*")
public class QrcodeController {
	
	@GetMapping
	public byte[] gerarQrCode() {
		try {
			return GerarQrCode.gerarQrCode();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
