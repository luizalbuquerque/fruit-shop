package fruit.shop.api.service.impl;

import fruit.shop.api.entity.ItemEntity;
import fruit.shop.api.repository.ItemRepository;
import fruit.shop.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<ItemEntity> listarItem() {
        return itemRepository.findAll();
    }
}
