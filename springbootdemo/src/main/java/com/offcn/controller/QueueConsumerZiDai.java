package com.offcn.controller;

import java.util.Map;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumerZiDai {

	@JmsListener(destination="map")
	public void getMessage(Map map) {
		System.out.println(map);
	}
}
