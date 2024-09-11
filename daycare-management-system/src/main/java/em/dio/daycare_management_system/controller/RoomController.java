package em.dio.daycare_management_system.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import em.dio.daycare_management_system.domain.model.Room;
import em.dio.daycare_management_system.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/rooms")

public record RoomController(RoomService service) {

	
	@GetMapping
	@Operation(summary = "Get all rooms", description = "Retrieve a list of rooms registered and their children")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
	public ResponseEntity<List<Room>> findAll() {
		var rooms = service.findAll();
		
		return ResponseEntity.ok(rooms);
	}
	
	
    @PostMapping
    @Operation(summary = "Create a new room", description = "Create a new room and return the created room's data")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "201", description = "Room created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid room data provided")
    })	
	public ResponseEntity<Room> create(@RequestBody Room roomToCreate) {
    	var room = service.create(roomToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(room.getId())
                .toUri();
        return ResponseEntity.created(location).body(room);
	}
    
    @GetMapping("/{id}")
    @Operation(summary = "Get a room by ID", description = "Retrieve a specific user based on its ID")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "Room not found")
    })
    public ResponseEntity<Room> findById(@PathVariable Long id) {
        var room = service.findById(id);
        return ResponseEntity.ok(room);
    }
    
    
    @PutMapping("/{id}")
    @Operation(summary = "Update a user", description = "Update the data of an existing user based on its ID")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "422", description = "Invalid user data provided")
    })
    public ResponseEntity<Room> update(@PathVariable Long id, @RequestBody Room room) {
        var updatedRoom = service.update(id, room);
        return ResponseEntity.ok(updatedRoom);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a room", description = "Delete an existing room based on its ID")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "204", description = "Room deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Room not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
