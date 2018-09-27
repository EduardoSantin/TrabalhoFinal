package principal.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="codigo")
@ToString(of={"codigo","nome"})
	
	public class Login implements Serializable {
	
	private static final long serialVersionUID = 8371791443332934642L;
	
	private Integer codigo;
	private String nome;
	

}
