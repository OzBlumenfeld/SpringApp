// package com.example.demo;

// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// @AutoConfigureMockMvc
// public class EmployeeControllerTests {
//     @Autowired
//     private MockMvc mvc;
//     @Test
//     @WithMockUser()
//     public void givenNoEmployee_whenCreateEmployee_thenEmployeeCreated() throws Exception {
//         mvc.perform(post("/employees").content(
//             new ObjectMapper().writeValueAsString(new Employee("First", "Last"))
//             .with(csrf()))
//           .contentType(MediaType.APPLICATION_JSON)
//           .accept(MediaType.APPLICATION_JSON))
//           .andExpect(MockMvcResultMatchers.status()
//             .isCreated())
//           .andExpect(jsonPath("$.firstName", is("First")))
//           .andExpect(jsonPath("$.lastName", is("Last")));
//     }
//     // other tests as necessary
// }