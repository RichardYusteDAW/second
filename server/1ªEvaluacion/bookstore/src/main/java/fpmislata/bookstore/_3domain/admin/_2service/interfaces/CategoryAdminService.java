package fpmislata.bookstore._3domain.admin._2service.interfaces;

import fpmislata.bookstore._3domain.admin._1model.Category;
import java.util.List;

public interface CategoryAdminService {

    List<Category> findAll();

    Category findById(Integer id);

    Integer create(Long id, String name, String slug);

    Boolean update(Long id, String name, String slug);

    Boolean delete(Integer id);
}