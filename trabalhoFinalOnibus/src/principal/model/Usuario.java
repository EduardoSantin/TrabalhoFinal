package principal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(of="codigo")
@ToString(of = {"login","senha"})
	
	public class Usuario {
	
	//private int codigo;
	private String login;
	private String senha;	
	
}
