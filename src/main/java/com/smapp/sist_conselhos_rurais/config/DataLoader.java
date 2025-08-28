package com.smapp.sist_conselhos_rurais.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.smapp.sist_conselhos_rurais.models.Perfil;
import com.smapp.sist_conselhos_rurais.repository.PerfilRepository;

@Component
public class DataLoader implements CommandLineRunner {

	private final PerfilRepository repository;
    public DataLoader(PerfilRepository repository){ this.repository = repository; }
	
	@Override
	public void run(String... args) throws Exception {
        if (repository.findByNome("ASSOCIADO").isEmpty()) repository.save(new Perfil(null,"ASSOCIADO","Acesso básico"));
        if (repository.findByNome("PRESIDENTE").isEmpty()) repository.save(new Perfil(null,"PRESIDENTE","Acesso médio"));
        if (repository.findByNome("GESTOR").isEmpty()) repository.save(new Perfil(null,"GESTOR","Acesso total"));

	}

}
