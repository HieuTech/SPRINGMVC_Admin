package rikkei.ss20_addtocart_session.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rikkei.ss20_addtocart_session.dao.impl.CategoryDaoHibernate;
import rikkei.ss20_addtocart_session.dto.request.ProductRequest;
import rikkei.ss20_addtocart_session.dto.response.ProductResponse;
import rikkei.ss20_addtocart_session.dto.response.UserResponse;
import rikkei.ss20_addtocart_session.entity.Products;
import rikkei.ss20_addtocart_session.service.AuthenServiceHibernate;
import rikkei.ss20_addtocart_session.service.CategoryServiceHibernate;
import rikkei.ss20_addtocart_session.service.ProductServiceHibernate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/Products")
public class ProductController {

    ProductServiceHibernate productServiceHibernate;

    HttpSession httpSession;

    CategoryServiceHibernate categoryServiceHibernate;

    @GetMapping()
    public String listProduct(Model model) {

        if (httpSession.getAttribute("user") == null) {
            UserResponse userResponse = (UserResponse) httpSession.getAttribute("user");
            model.addAttribute("user", userResponse);
            return "redirect:/authen/login";
        } else {
            model.addAttribute("productList", productServiceHibernate.findAll());
            return "products/listProduct";
        }


    }

    @GetMapping("/add")
    public String formAddProduct(Model model) {
        model.addAttribute("product", new ProductRequest());
        model.addAttribute("categoryList", this.categoryServiceHibernate.findAll());

        return "products/addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") @Valid ProductRequest productRequest, @RequestParam("categoryId") Integer categoryId, HttpServletRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/Products/add";
        }

        String path = request.getServletContext().getRealPath("uploads");
        File file = new File(path);
        MultipartFile imgFile = productRequest.getFile();
        String fileName = imgFile.getOriginalFilename();

        try {
            //Khoi tao duong dan cua file se copy len
            File destination = new File(file.getAbsolutePath() + "/" + fileName);
            if (!destination.exists()) {
                FileCopyUtils.copy(imgFile.getBytes(), destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean result = this.productServiceHibernate.insertProduct(productRequest, fileName, categoryId);
        if (result) {
            return "redirect:/Products";
        } else {
            return "products/addProduct";
        }

    }

    @GetMapping("/edit/{id}")
    public String formUpdateProduct(@PathVariable("id") Integer id, ModelMap modelMap) {
        modelMap.addAttribute("product", this.productServiceHibernate.findById(id));
        modelMap.addAttribute("categoryList", this.categoryServiceHibernate.findAll());

        return "products/editProduct";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        this.productServiceHibernate.deleteProduct(id);


        return "redirect:/Products";
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute("product") ProductRequest req, @RequestParam("categoryId") Integer categoryId, HttpServletRequest request) {


        String path = request.getServletContext().getRealPath("uploads");
        File file = new File(path);
        MultipartFile imgFile = req.getFile();
        String fileName = imgFile.getOriginalFilename();

        try {
            //Khoi tao duong dan cua file se copy len
            File destination = new File(file.getAbsolutePath() + "/" + fileName);
            if (!destination.exists()) {
                FileCopyUtils.copy(imgFile.getBytes(), destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean result = this.productServiceHibernate.updateProduct(req,categoryId, fileName);
        if (result) {
            return "redirect:/Products";
        } else {
            return "products/editProduct";
        }

        //        String fileName = null;
//        //Nếu chọn ảnh để update thì imageFile mới khác null và imageFile ko rỗng
//        if (imageFile != null && imageFile.isEmpty()) {
//            // Lấy đường dẫn tương đối
//            String path = request.getServletContext().getRealPath("reloads");
//            //Khoi 1 doi tuong file theo duong dan tuong doi de lay duong dan tuyet doi;
//            File file = new File(path);
//            //lấy tên file file cần upload lên
//
//             fileName = imageFile.getOriginalFilename();
//            try {
//                //Khởi tạo đường dẫn của file sẽ copy lên
//
//                File destination = new File(file.getAbsolutePath() + "/" + fileName);
//                if (!destination.exists()) {
//                    FileCopyUtils.copy(imageFile.getBytes(), destination);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        if (this.productServiceHibernate.updateProduct(req, categoryId, fileName)) {
//            return "redirect:/Products";
//
//        } else {
//            return "products/editProduct";
//        }
    }
}
