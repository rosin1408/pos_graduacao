/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.pessoa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author Roberto
 * @data 13/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Cliente extends Pessoa implements Serializable {

}
