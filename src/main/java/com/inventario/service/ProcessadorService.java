package com.inventario.service;

import java.util.List;

import com.inventario.models.ProcessadorModel;

public interface ProcessadorService {

	//É implementado os métodos
	
	List<ProcessadorModel> listarProcessadores();
	ProcessadorModel findById(Integer id);
	ProcessadorModel save(ProcessadorModel processadorModel);
}
