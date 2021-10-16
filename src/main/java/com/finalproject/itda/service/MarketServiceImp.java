package com.finalproject.itda.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.MarketDAO;

@Service
public class MarketServiceImp implements MarketService {
	@Inject
	MarketDAO marketDAO;
}
