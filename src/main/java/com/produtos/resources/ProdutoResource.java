package com.produtos.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.produtos.model.Produto;
import com.produtos.repository.ProdutoRepository;



@RestController
@RequestMapping(value="/api")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> listaProduto(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produto listaProdutoId(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	public void deletaProduto(@RequestBody Produto produto) {
		 produtoRepository.delete(produto);
	}
	
	
	@PutMapping("/produto")
	public Produto alterarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	
	}

}
