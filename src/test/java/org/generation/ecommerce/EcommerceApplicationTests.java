package org.generation.ecommerce;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.generation.ecommerce.model.Product;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.containsString;
@SpringBootTest
@AutoConfigureMockMvc
class EcommerceApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	private final String token="Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbXloQGdtYWlsLmNvbSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzExOTkzOTk4LCJleHAiOjE3MTIwMjk5OTh9.78kbBzQWEd9TF5I4-DLfHecMFdDO8mmJrLJs5F4G87Y";
	@Test
	@DisplayName("Se prueba el endpoint http://localhost:8080/api/products/1")
	void pruebaGET() throws Exception {
		this.mockMvc.perform( get("/api/products/1") )
							.andDo(print())
							.andExpect(status().isOk() )
							.andExpect(
									content().string(containsString("87808.jpeg") )
									);
	}//pruebaGET

	@Test
	@Disabled("Probado la primera vez, deshabilitado")
	@DisplayName("Se prueba borrar el producto con id 8 http://localhost:8080/api/products/8")
	void pruebaDELETE() throws Exception {
		this.mockMvc.perform( delete("/api/products/8").header("Authorization", token) )
							.andDo(print())
							.andExpect(status().isOk() )
							.andExpect(
			content().string(containsString("Pluma y Lapicero Zebra Z-Grip Silver Azul") )
						);
	}//pruebaDELETE
	
	@Test
	@DisplayName("Se prueba cear un producto nuevo")
	@Disabled("Ya se probó la creación del producto")
	void pruebaPOST() throws Exception {
		Product p = new Product();
		p.setName("Pluma y Lapicero Zebra Z-Grip Silver");
		p.setDescription("Pluma y Lapicero Zebra Z-Grip Silver Azul");
		p.setURL_image("100161506.jpeg");
		p.setPrice(79);
		this.mockMvc.perform( post("/api/products/")
							.contentType(MediaType.APPLICATION_JSON)
							.content( asJsonString(p) )
							.header("Authorization", token) )
							.andDo(print())
							.andExpect(status().isOk() )
							.andExpect(
			content().string(containsString("Pluma y Lapicero Zebra Z-Grip Silver Azul") )
						);
	}//pruebaPOST
	
	private static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
	 } // asJsonString
	
	
	@Test
	@DisplayName("Se prueba modificar el producto ")
	void pruebaPUT() throws Exception {
		Product p = new Product();
		p.setName(""); p.setDescription("");  p.setURL_image("");
		p.setPrice(49.99);
		this.mockMvc.perform( put("/api/products/4")
							.contentType(MediaType.APPLICATION_JSON)
							.content( asJsonString(p) )
							.header("Authorization", token) )
							.andDo(print())
							.andExpect(status().isOk() )
							.andExpect(
			content().string(containsString("49.99") ));
	}//pruebaPUT
	
	

}//class EcommerceApplicationTests
