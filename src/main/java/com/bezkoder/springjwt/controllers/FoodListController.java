package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dto.FoodListDTO;
import com.bezkoder.springjwt.exception.ResourceNotFoundException;
import com.bezkoder.springjwt.mapper.FoodListMapper;
import com.bezkoder.springjwt.models.FoodList;
import com.bezkoder.springjwt.repository.FoodListRepository;
import com.bezkoder.springjwt.service.FoodListService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

@RestController
@RequestMapping("/api")
public class FoodListController {
    private final FoodListService foodListService;
    private final FoodListMapper foodListMapper;
    private final FoodListRepository foodListRepository;
    public FoodListController(FoodListService foodListService,FoodListMapper foodListMapper,FoodListRepository foodListRepository){
        this.foodListService = foodListService;
        this.foodListMapper = foodListMapper;
        this.foodListRepository = foodListRepository;
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    @GetMapping("/sortedfoodlists")
    public ResponseEntity<List<FoodList>> getAllTutorials(@RequestParam(defaultValue = "id,desc") String[] sort) {

        try {
            List<Order> orders1 = new ArrayList<Order>();

            if (sort[0].contains(",")) {
                // will sort more than 2 fields
                // sortOrder="field, direction"
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    orders1.add(new Order(getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
                // sort=[field, direction]
                orders1.add(new Order(getSortDirection(sort[1]), sort[0]));
            }

            List<FoodList> foodLists = foodListRepository.findAll(Sort.by(orders1));

            if (foodLists.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(foodLists, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/foodlistpage")
    public ResponseEntity<Map<String, Object>> getAllTutorialsPage(
            @RequestParam(required = false) String foodListName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort) {

        try {
            List<Order> orders = new ArrayList<Order>();

            if (sort[0].contains(",")) {
                // will sort more than 2 fields
                // sortOrder="field, direction"
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
                // sort=[field, direction]
                orders.add(new Order(getSortDirection(sort[1]), sort[0]));
            }

            List<FoodList> foodLists = new ArrayList<FoodList>();
            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<FoodList> pageTuts;
            if (foodListName == null)
                pageTuts = foodListRepository.findAll(pagingSort);
            else
                pageTuts = foodListRepository.findByFoodListNameContaining(foodListName, pagingSort);

            foodLists = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("foodlists", foodLists);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/foodlists/foodListName")
    public ResponseEntity<Map<String, Object>> findByFoodListName(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(required = false) String foodListName) {

        try {
            List<FoodList> foodLists = new ArrayList<FoodList>();
            Pageable paging = PageRequest.of(page, size);

            Page<FoodList> pageTuts = foodListRepository.findByFoodListName(String.valueOf(foodListName), paging);
            foodLists = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("tutorials", foodLists);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/foodlist/{id}")
    public ResponseEntity<FoodListDTO>getOne(@PathVariable("id")Long id) throws ResourceNotFoundException {
        Optional<FoodList> foodList = foodListService.findOne(id);
        FoodListDTO foodListDTO = foodListMapper.entityToDTO(foodList.orElseThrow(()->new ResourceNotFoundException("foodlist: "+id+" not found")));
        return ResponseEntity.ok(foodListDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/foodlists")
    public ResponseEntity<List<FoodListDTO>>getAll(){
        List<FoodListDTO>foodLists = foodListMapper.entityToDTO(foodListService.findAll());
        return ResponseEntity.ok(foodLists);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/foodlist")
    public ResponseEntity<FoodListDTO>create(@RequestBody FoodList foodList){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        FoodListDTO foodListDTO = foodListMapper.entityToDTO(foodListService.save(foodList));
        ResponseEntity.BodyBuilder responsebuilder = ResponseEntity.ok().headers(headers);
        if(foodListDTO!=null){
            return responsebuilder.body(foodListDTO);
        }
        else{
            return responsebuilder.body(new FoodListDTO());
        }
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/foodlist/{id}")
    public ResponseEntity<FoodListDTO>update(@PathVariable("id")Long id,FoodList foodList){
        FoodListDTO foodListDTO = foodListMapper.entityToDTO(foodListService.update(id,foodList));
        return ResponseEntity.ok(foodListDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/foodlist/{id}")
    public Map<String,Boolean>delete(@PathVariable("id")Long id){
        Optional<FoodList>foodList = foodListService.findOne(id);
        FoodList foodList1 = foodList.get();
        foodListService.delete(foodList1);
        Map<String,Boolean>response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
