package com.inventario.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.exception.ProcessadorNotFoundException;
import com.inventario.models.ProcessadorModel;
import com.inventario.repositories.ProcessadorRepository;
import com.inventario.service.ProcessadorService;

@Service
public class ProcessadorServiceImpl implements ProcessadorService{

	@Autowired
	ProcessadorRepository processadorRepository;
	
	@Override
	public List<ProcessadorModel> listarProcessadores() {
		// TODO Auto-generated method stub
		return processadorRepository.findAll();
	}

	@Override
	public ProcessadorModel findById(Integer id) {
		// TODO Auto-generated method stub
		return processadorRepository.findById(id).get();
	}

	@Override
	public ProcessadorModel save(ProcessadorModel processadorModel) {
		// TODO Auto-generated method stub
		return processadorRepository.save(processadorModel);
	}
	
	public ProcessadorModel buscarProcessadorPorId(Integer id) throws ProcessadorNotFoundException {
		Optional<ProcessadorModel> opt = processadorRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new ProcessadorNotFoundException("Processador com id: " + id + " não existe!");
		}
	}

	public ProcessadorModel apagarProcessador(Integer id) throws ProcessadorNotFoundException{
		ProcessadorModel processadorModel = buscarProcessadorPorId(id);
		processadorRepository.delete(processadorModel);
		return processadorModel;
	}
	
	public ProcessadorModel deletarProcessador(Integer id) {
		processadorRepository.deleteById(id);
		ProcessadorModel processadorModel = null;
		return processadorModel;
	}
}
