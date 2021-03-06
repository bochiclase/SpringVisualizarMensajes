package com.marcos.muroMensajes.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marcos.muroMensajes.datos.usuarios.UsuarioDAO;
import com.marcos.muroMensajes.datos.usuarios.Usuario;

@Service
public class Autenticacion implements UserDetailsService 

{
	@Autowired
	private UsuarioDAO usuarioDAO;
		
	
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		
		Optional<Usuario> user = usuarioDAO.findById(username);
		
		if(user.isPresent()) {
			
			return user.get();
		}
		else throw new  UsernameNotFoundException(""+username);
	}
}
