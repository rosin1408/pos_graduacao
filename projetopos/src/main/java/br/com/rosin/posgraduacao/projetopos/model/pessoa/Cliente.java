/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.pessoa;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author Roberto
 * @data 13/10/2014
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Cliente extends Pessoa {

}
