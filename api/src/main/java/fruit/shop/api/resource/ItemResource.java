package fruit.shop.api.resource;

import fruit.shop.api.repository.ItemRepository;
import fruit.shop.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/item", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemResource {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<CartaoEntity> listar() {
        return cartaoService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void gerar() {
        cartaoService.gerarNovoCartao();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cartaoService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") long id) {
        cartaoRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);}

    @PutMapping("/{id}")
    public ResponseEntity<CartaoEntity> updateCartao(@PathVariable("id") long id, @RequestBody CartaoEntity cartaoAtualizado) {
        CartaoEntity _cartao = cartaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado o Cartão com id = " + id));

        _cartao.setNumeroCartao(cartaoAtualizado.getNumeroCartao());
        _cartao.setPassword(cartaoAtualizado.getPassword());
        _cartao.setSaldo(cartaoAtualizado.getSaldo());

        return new ResponseEntity<>(cartaoRepository.save(_cartao), HttpStatus.OK);
    }


}
