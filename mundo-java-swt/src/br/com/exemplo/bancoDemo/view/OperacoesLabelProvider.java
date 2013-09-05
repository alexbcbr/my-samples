package br.com.exemplo.bancoDemo.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import br.com.exemplo.bancoDemo.common.IOperacao;
import br.com.exemplo.bancoDemo.common.OperacaoVO;

/**
 * Esta classe fornece os textos de rótulos para OperacoesTable
 */
public class OperacoesLabelProvider implements ITableLabelProvider {
  // Imagem para apresentar indice critico
  private Image ball;

  public OperacoesLabelProvider() {
    try {
      ball = new Image(null, new FileInputStream("imagens/ball.png"));
    } catch (FileNotFoundException e) {
    	System.out.println("Nao encontrei a imagem");
    }
  }

  public Image getColumnImage(Object arg0, int arg1) {
    OperacaoVO operacoes = (OperacaoVO) arg0;
    Image image = null;
    switch (arg1) {
    	case IOperacao.COLUMN_OPERACAO:
    		break;
    	case IOperacao.COLUMN_RENTABILIDADE:
    		break;
    	case IOperacao.COLUMN_VOLUME:
    		if (operacoes.volumeCritico(arg1)) image = ball;
    		break;
    }
    return image;
  }

  public String getColumnText(Object arg0, int arg1) {
  	OperacaoVO operacao = (OperacaoVO) arg0;
    String text = "";
    switch (arg1) {
    case IOperacao.COLUMN_OPERACAO:
      text = operacao.getOperacao();
      break;
    case IOperacao.COLUMN_RENTABILIDADE:
      text = operacao.getRentabilidade();
      break;
    case IOperacao.COLUMN_VOLUME:
      text = String.valueOf(operacao.getVolume());
      break;
    }
    return text;
  }

  public void addListener(ILabelProviderListener arg0) {
  }

  public void dispose() {
    if (ball != null) ball.dispose();
  }

  public boolean isLabelProperty(Object arg0, String arg1) {
    return false;
  }

  public void removeListener(ILabelProviderListener arg0) {
  }
}
