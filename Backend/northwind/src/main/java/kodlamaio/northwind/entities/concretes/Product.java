package kodlamaio.northwind.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@Entity // anatasyon bazlı çalışma ile product javanın 1 entity olduğunu springe tanıtıyoruz.Sen 1 db nesnesisin diyoruz.
@Table(name="products") //db de hangi tabloya karşılık geleceğini tnıt.
public class Product {
	
	@Id //sorgular bu id ye göre yapılandırılacak. db ve diğer işlere primary keye tanıyıtoruz.
	@GeneratedValue(strategy = GenerationType.IDENTITY)//tekrar anlatmak lazım otomatik at diye strateji yazıyoruz. //id nin nasıl arttırıldığını anlatmamız lazım. bu seçtiğimiz 1 1 arttığını gösteriri. 
	@Column(name="product_id")  //hangi kolana denk geliyor..
	private int id;

	//@Column(name="category_id") 
	//private int categoryId;

	@Column(name="product_name") 
	private String productName;

	@Column(name="unit_price") 
	private double unitPrice;

	@Column(name="units_in_stock") 
	private short unitsInStock;

	@Column(name="quantity_per_unit") 
	private String quantityPerUnit;

    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;
	
//	@ManyToOne(optional = false)
//	@JoinColumn(name = "category_id", insertable = false, updatable = false)
//    private Category category;
	
//	@ManyToOne()
  //  @JoinColumn(name="category_id") //hangi product olduğunu soruyoruz. tek tek çağrıyor. id li olanı commentleyebiliriz. 
  //  private Category category;

	

	

}
