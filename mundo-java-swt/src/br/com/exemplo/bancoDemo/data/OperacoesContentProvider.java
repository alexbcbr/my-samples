package br.com.exemplo.bancoDemo.data;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import br.com.exemplo.bancoDemo.common.AgenciaVO;

public class OperacoesContentProvider implements IStructuredContentProvider {

  public Object[] getElements(Object arg0) {
    return ((AgenciaVO) arg0).getOperacoes().toArray();
  }

  public void dispose() {
  }

  /**
   * Método chamado no caso de haver entrada de dados
   */
  public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
  }
}