package com.web_project.shop.controllers;

import com.web_project.shop.model.TagModel;
import com.web_project.shop.service.TagServiceIMPL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/tags")
//@PreAuthorize("hasAnyAuthority('MODERATOR')")
public class TagController {

    @Autowired
    private TagServiceIMPL tagService;

    @GetMapping("/all")
    public String getAllTags(Model model) {
        model.addAttribute("tags", tagService.findAll());
        model.addAttribute("tag", new TagModel());
        return "tagList";
    }

    @PostMapping("/add")
    public String addTag(@Valid @ModelAttribute("tag") TagModel tag, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("tags", tagService.findAll());
            return "tagList";
        }
        tagService.add(tag);
        return "redirect:/tags/all";
    }

    @GetMapping("/edit/{id}")
    public String getTagForEdit(@PathVariable UUID id, Model model) {
        TagModel tag = tagService.findById(id);
        model.addAttribute("tag", tag);
        return "editTag"; // Отображение страницы редактирования
    }

    @PostMapping("/update")
    public String updateTag(@Valid @ModelAttribute("tag") TagModel tag, BindingResult result) {
        if (result.hasErrors()) {
            return "editTag"; // Если есть ошибки, возвращаемся на страницу редактирования
        }
        tagService.update(tag);
        return "redirect:/tags/all";
    }

    @PostMapping("/delete")
    public String deleteTag(@RequestParam UUID id) {
        tagService.delete(id);
        return "redirect:/tags/all";
    }
}
