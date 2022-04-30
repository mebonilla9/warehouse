package co.edu.umb.warehouse.domain.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "provider")
public class Provider implements Serializable {

  @Id
  @SequenceGenerator(
    name = "provider_id_sequence",
    sequenceName = "provider_id_sequence"
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "provider_id_sequence"
  )
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "enable", nullable = false)
  private boolean enable;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Provider provider = (Provider) o;
    return id != null && Objects.equals(id, provider.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}