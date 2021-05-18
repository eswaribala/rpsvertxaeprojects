package reactivestreamsdemo;

 /*
@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ProductController.class)
@Import(ProductService.class)
public class ProductControllerTest 
{
    @MockBean
    ProductRepository repository;
 
    @Autowired
    private WebTestClient webClient;
 
    @Test
    void testCreateProduct() {
       Product product=new Product();
        Mockito.when(repository.save(product)).thenReturn(Mono.just(product));
 
        webClient.post()
            .uri("/create")
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromObject(product))
            .exchange()
            .expectStatus().isCreated();
 
        Mockito.verify(repository, times(1)).save(product);
    }
     
 
}
*/