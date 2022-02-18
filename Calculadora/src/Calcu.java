

import java.awt.BorderLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
//import javax.swing.JOptionPane;
import javax.swing.*;

public class Calcu {
 
	// Constantes
	final int MAX_DIGITS = 5 ;
	final int MODE_ENTRADA = 0 ;
	final int MODE_RESULTADO = 1 ;
 
	//Variables
	int modo ;
	int valor1 ;
	int valor2 ;
	String operacion ;
	boolean inicializa_resultado ;
 
	private static Text texto_resultado;
	//private static String texto_resultado;
	
	public Calcu(boolean gui) {
 
		//Inicializaci�n de las variables.
		inicializa();
		if ( gui == true ) dibuja_Calculadora();
	}
 
	private void dibuja_Calculadora ( ) {
 
		Display display = Display.getDefault();
		Shell shlCalculadora = new Shell();
		shlCalculadora.setSize(259, 250);
		shlCalculadora.setText("Calculadora");
 
		//------------------------------------------------ -
		//N�meros
		//------------------------------------------------ -
 
		//bot�n con el n�mero 0
		Button button_0 = new Button(shlCalculadora, SWT.NONE);
		button_0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anade_NuevoDigito(0);
			}
		});
		button_0.setText("0");
		button_0.setBounds(23, 163, 40, 33);
 
		//bot�n con el n�mero 1
		Button button_1 = new Button(shlCalculadora, SWT.NONE);
		button_1.addSelectionListener ( new SelectionAdapter ( ) {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anade_NuevoDigito(1);
			}
		});
		button_1.setText("1");
		button_1.setBounds(23, 124, 40, 33);
 
		//bot�n con el n�mero 2
		Button button_2 = new Button(shlCalculadora, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anade_NuevoDigito(2);
			}
		});
		button_2.setText("2");
		button_2.setBounds(69, 124, 40, 33);
 
		//bot�n con el n�mero 3
		Button button_3 = new Button(shlCalculadora, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected (SelectionEvent e) {
				anade_NuevoDigito(3);
			}
		});
		button_3.setText("3") ;
		button_3.setBounds(115, 124, 40, 33);
		
		//	bot�n con el n�mero 4
		Button button_4 = new Button (shlCalculadora, SWT.NONE);
		button_4.addSelectionListener (new SelectionAdapter() {
			@Override
			public void widgetSelected (SelectionEvent e) {
				anade_NuevoDigito(4);
			}
		});
		button_4.setText("4");
		button_4.setBounds(23, 85, 40, 33);
		
		//bot�n con el n�mero 5
		Button button_5 = new Button(shlCalculadora, SWT.NONE);
		button_5.addSelectionListener (new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anade_NuevoDigito(5);
			}
		});
		button_5.setText("5");
		button_5.setBounds(69, 85, 40, 33);
		
		//bot�n con el n�mero 6
		Button button_6 = new Button (shlCalculadora, SWT.NONE);
		button_6.addSelectionListener (new SelectionAdapter() {
			@Override
			public void widgetSelected (SelectionEvent e) {
				anade_NuevoDigito(6);
			}
		});
		button_6.setText("6");
		button_6.setBounds(115, 85, 40, 33);
 
		//bot�n con el n�mero 7
		Button button_7 = new Button(shlCalculadora, SWT.NONE);
		button_7.addSelectionListener (new SelectionAdapter () {
			@Override
			public void widgetSelected (SelectionEvent e) {
				anade_NuevoDigito(7);
			}
		});
		button_7.setText("7");
		button_7.setBounds(23, 46, 40, 33);
 
		//bot�n con el n�mero 8
		Button button_8 = new Button(shlCalculadora, SWT.NONE);
		button_8.addSelectionListener (new SelectionAdapter () {
			@Override
			public void widgetSelected (SelectionEvent e) {
				anade_NuevoDigito(8);
			}
		});
		button_8.setBounds(69, 46, 40, 33);
		button_8.setText("8");
 
		//bot�n con el n�mero 9
		Button button_9 = new Button(shlCalculadora, SWT.NONE);
		button_9.addSelectionListener (new SelectionAdapter() {
			@Override
			public void widgetSelected (SelectionEvent e) {
				anade_NuevoDigito(9);
			}
		});
		button_9.setText("9");
		button_9.setBounds(115, 46, 40, 33);
		
		
		//------------------------------------------------ -
		//Operaciones
		//------------------------------------------------ -
 
		//bot�n con la operaci�n de divisi�n
		Button button_12 = new Button (shlCalculadora, SWT.NONE);
		button_12.addSelectionListener (new SelectionAdapter () {
			@Override
			public void widgetSelected (SelectionEvent e) {
				ejecutarOperador("/");
			}
		});
		button_12.setText("/");
		button_12.setBounds(178,46, 40, 33);
		
		//bot�n con la operaci�n de multiplicaci�n
		Button button_13 = new Button (shlCalculadora, SWT.NONE);
		button_13.addSelectionListener (new SelectionAdapter () {
			@Override
			public void widgetSelected (SelectionEvent e) {
				ejecutarOperador("*");
			}
		});
		button_13.setText("*");
		button_13.setBounds(178, 85, 40, 33);
		
		//	bot�n con la operaci�n de suma
		Button button_14 = new Button (shlCalculadora, SWT.NONE);
		button_14.addSelectionListener (new SelectionAdapter () {
			@Override
			public void widgetSelected (SelectionEvent e) {
				ejecutarOperador("+");
			}
		});
		button_14.setText("+");
		button_14.setBounds(178, 124, 40, 33);
		
		//bot�n con la operaci�n de resto
		Button button_15 = new Button (shlCalculadora, SWT.NONE);
		button_15.addSelectionListener (new SelectionAdapter() {
			@Override
			public void widgetSelected (SelectionEvent e) {
				ejecutarOperador("-");
			}
		});
		button_15.setText("-");
		button_15.setBounds(178, 163, 40, 33);
		
		//bot�n con la operaci�n de igual
		Button button_11 = new Button (shlCalculadora, SWT.NONE);
		button_11.addSelectionListener (new SelectionAdapter() {
			@Override
			public void widgetSelected (SelectionEvent e) {
				ejecutarIgual();
			}
		});
		button_11.setText("=");
		button_11.setBounds(69, 163, 86, 33);
		
		//Texto donde se visualiza el resultado
		texto_resultado = new Text (shlCalculadora, SWT.BORDER);
		texto_resultado.setText("0");
		texto_resultado.setBounds(22, 19, 196, 21);
		
		shlCalculadora. open ( ) ;
		shlCalculadora. layout ( ) ;
		while ( ! shlCalculadora. isDisposed ( ) ) {
			if ( ! display. readAndDispatch ( ) ) {
				display. sleep ( ) ;
			}
		}
	}
	
	void inicializa ( ) {
		operacion = "null";
		valor1 = 0;
		valor2 = 0;
		modo = MODE_ENTRADA;
		inicializa_resultado = true;
	}
	
	String getResultadoString() {
		return texto_resultado.getText();
	}
	
	void setResultadoString (String s) {
		texto_resultado.setText(s);
	}
	
	int getResultadoInt ( ) {
		String resultado = texto_resultado.getText();
		return Integer.parseInt(resultado);
	}
	
	void anade_NuevoDigito(int digito) {
		if(inicializa_resultado)
			setResultadoString("");
		
		String inputString = getResultadoString();
 
		if ( inputString.indexOf("0") == 0) {
			inputString = inputString.substring(1);
		}
 
		if ( ( !inputString.equals("0") || digito > 0) && inputString.length() < MAX_DIGITS) {
			setResultadoString(inputString + digito);
		}
		
		modo = MODE_ENTRADA;
		inicializa_resultado = false;
	}
	
	void ejecutarOperador ( String nueva_operacion ) {
		int resultado;
		
		if (operacion.equals("null")) {
			resultado = getResultadoInt();
			valor1 = resultado;
		} else {
			valor2 = getResultadoInt();
			resultado = ejecutar_Operacion();
			muestraResultado(resultado);
			valor1 = resultado;
		}
		
		inicializa_resultado = true;
		operacion = nueva_operacion;
	}
 
	void ejecutarIgual( ) {
		int resultado = 0;
		
		valor2 = getResultadoInt();
		resultado = ejecutar_Operacion();
		muestraResultado(resultado);
		
		operacion = "null";
	}
 
	int ejecutar_Operacion () {
		int resultado = 0;
 
		if ( operacion.equals("/")) {
			if (valor2 == 0) {
				JOptionPane.showMessageDialog(null, "No se puede dividir por cero", "Error", JOptionPane.ERROR_MESSAGE);
				operacion = "null";
				valor1 = 0;
				modo = MODE_ENTRADA;
				inicializa_resultado = true;
			}
			else
				resultado = valor1/valor2;
		}
		
		if (operacion.equals("/"))
			resultado = valor1/valor2;
		
		if (operacion.equals("*"))
			resultado = valor1*valor2;
		
		if (operacion.equals("-"))
			resultado = valor1 - valor2;
		
		if (operacion.equals("+"))
			resultado = valor1 + valor2;
		
		return resultado;
	}
	
	void muestraResultado (int resultado) {
		setResultadoString(Integer.toString(resultado));
		valor1 = resultado;
		modo = MODE_RESULTADO;
		inicializa_resultado = true;
	}
	
	public static void main (String args[]) {
		Calcu calculadora = new Calcu(true);
	}
 
}