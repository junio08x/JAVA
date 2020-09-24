package aula.pkg1;
/* As seguintes linhas permitem o uso das classes de entrada e sa�da e de processamento
de tokens */
import java.io.*;
import java.util.*;
/**
* A classe Keyboard permite a leitura de dados de tipos nativos e de
* inst�ncias da classe String a partir do teclado. Basicamente esta classe
* encapsula o funcionamento do Stream System.in, que pode ser usado como
* entrada padr�o de dados.
*
* Esta classe � baseada na classe EasyIn, de Peter van der Linden. As
* principais modifica��es foram:
*
*
Os m�todos s�o est�ticos para facilitar o uso da classe
*
Cria��o de m�todos sobrecarregados para que valores default possam ser
* usados
*
Melhor tratamento das exce��es
*
Reconhecimento de v�rios valores como booleanos e capacidade de leitura de
* NaNs e infinitos para valores dos tipos float e
* double
*
Descri��o dos detalhes de implementa��o com coment�rios
*
* A classe permite o uso de arquivos de respostas ("answer files"), que s�o
* arquivos contendo os dados que deveriam ser entrados pelo teclado. A entrada destes
* dados pode ser simulada atrav�s de redirecionamento de arquivos. Se, por exemplo,
* tivermos uma aplica��o (classe) DemoDataKeyboard e quisermos usar um arquivo
* de respostas chamado dados.dat que j� cont�m os dados que devem ser
* digitados, podemos executar o comando java DemoDataKeyboard < dados.dat
* para ler os dados do arquivo em vez do teclado. O comando ser� o mesmo para
* os sistemas operacionais Windows e Linux.
*
* O suporte a arquivos de respostas � limitado, somente funcionar� se todos os dados
* a serem digitados forem entrados no arquivo de respostas, um em cada linha.
* Exce��es ocorrer�o caso estas regras n�o sejam seguidas.
*
* A mensagem original de copyright de Peter van de Linden � mostrada ao final desta
* listagem. Vale a pena notar que a sintaxe proposta e mostrada na mensagem �
* diferente da usada pela classe Keyboard.
*
* O livro "An Introduction to Computer Science Using Java", de Samuel N. Kamin,
* M. Dennis Mickunas e Edward M. Reingold (editora McGraw-Hill, ISBN 0-07-034224-5)
* tamb�m apresenta uma classe Keyboard, cujo funcionamento e c�digo s�o
* diferentes desta.
*
* @author Rafael Santos
* @version 1.2
*/
public class Keyboard
{
/**
* Declara��o dos campos privados desta classe.
*/
// O campo is � uma inst�ncia da classe InputStreamReader que ser� constru�da a
// partir do stream System.in. Note que j� que esta classe s� tem m�todos est�ticos,
// n�o ter� construtor, mas podemos inicializar inst�ncias de classes da forma mostrada
// abaixo.
private static InputStreamReader is = new InputStreamReader( System.in );
// O campo br � uma inst�ncia da classe BufferedReader que usa
// is como argumento para seu construtor.
private static BufferedReader br = new BufferedReader( is );
// O campo st � uma inst�ncia da classe StringTokenizer que ser�
// usada em v�rios m�todos nesta classe.
private static StringTokenizer st;
// O campo nt � uma inst�ncia da classe String que ser� usada em
// v�rios m�todos nesta classe.
private static String nt;
// O campo debug estabelece se mensagens de erro de convers�o e leitura
// devem ser mostradas ou n�o. O campo n�o pode ser modificado diretamente,
// somente atrav�s de m�todos espec�ficos descritos abaixo.
private static boolean debug = false;
/**
* O m�todo getToken l� uma string do BufferedReader associado com
* a entrada padr�o e retorna uma inst�ncia de StringTokenizer contendo os
* tokens criados a partir da linha lida. O m�todo � declarado como
* private pois s� dever� ser chamado a partir de outros m�todos da classe.
* @return uma inst�ncia de StringTokenizer contendo os tokens
* obtidos da linha lida
* @exception IOException se um erro de entrada e sa�da ocorrer.
* @exception NullPointerException se uma string vazia for lida e tentarmos construir
* uma inst�ncia de StringTokenizer com ela
* @see java.util.StringTokenizer StringTokenizer
*/
private static StringTokenizer getToken() throws IOException, NullPointerException
{
String s = br.readLine();
return new StringTokenizer(s);
} // fim do m�todo getToken
/**
* O m�todo readBoolean l� e retorna um valor do tipo boolean.
* Este m�todo simplesmente chama o m�todo readBoolean com argumentos,
* descrito abaixo, considerando o valor default como sendo true.
* @return o valor do tipo boolean lido (ou, em caso de erro de leitura,
* true)
*/
public static boolean readBoolean()
{
return readBoolean(true);
}
/**
* O m�todo readBoolean l� e retorna um valor do tipo boolean. Este
* m�todo tenta pegar o pr�ximo token a ser lido da entrada padr�o e o compara
* com algumas strings constantes para verificar a igualdade, retornando true
* ou false dependendo do resultado da compara��o.
* @param defaultvalue o valor default caso n�o seja poss�vel ler e decodificar
* um valor booleano
* @return o valor do tipo boolean lido (ou, em caso de erro de leitura, igual ao
* argumento passado para o m�todo)
*/
public static boolean readBoolean(boolean defaultvalue)
{
try
{
st = getToken(); // pega os tokens a partir da linha lida
nt = st.nextToken(); // e a primeira string do token.
// Retorna true se a string for igual a...
if (nt.equalsIgnoreCase("true") || // true
nt.equalsIgnoreCase("t") || // t
nt.equalsIgnoreCase("yes") || // yes
nt.equalsIgnoreCase("y") || // y
nt.equalsIgnoreCase("on") || // on
nt.equalsIgnoreCase("v") || // v
nt.equalsIgnoreCase("s") || // s
nt.equalsIgnoreCase("sim") || // sim
nt.equalsIgnoreCase("verdadeiro")) // verdadeiro
return true;
// Retorna false se a string for igual a...
else if (nt.equalsIgnoreCase("false") || // false
nt.equalsIgnoreCase("f") || // f
nt.equalsIgnoreCase("no") || // no
nt.equalsIgnoreCase("n") || // n
nt.equalsIgnoreCase("off") || // off
nt.equalsIgnoreCase("nao") || // nao
nt.equalsIgnoreCase("n�o") || // n�o
nt.equalsIgnoreCase("falso")) // falso
return false;
// Se n�o for nenhum dos valores reconhecidos, retorna o default
else return defaultvalue;
}
catch (IOException ioe) // se houver algum erro de leitura
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de entrada e sa�da lendo um boolean. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
catch (NoSuchElementException nsee) // se n�o houver tokens
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Entrada n�o cont�m um boolean. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
} // fim do m�todo readBoolean
/**
* O m�todo readByte l� e retorna um valor do tipo byte. Este
* m�todo simplesmente chama o m�todo readByte com argumentos, descrito
* abaixo, considerando o valor default como sendo (byte)0.
* @return o valor do tipo byte lido (ou, em caso de erro de leitura,
* (byte)0)
*/
public static byte readByte()
{
return readByte((byte)0);
} // fim do m�todo readByte
/**
* O m�todo readByte l� e retorna um valor do tipo byte. Este
* m�todo tenta pegar o pr�ximo token a ser lido da entrada padr�o e o
* passa como argumento para o m�todo parseByte da classe Byte,
* que tenta convert�-lo. Se a leitura e convers�o puderem ser feitas, um valor
* do tipo byte � retornado, caso contr�rio o valor default
* (passado como argumento) � retornado.
* @param defaultvalue o valor default caso n�o seja poss�vel ler e
* decodificar um valor do tipo byte
* @return o valor do tipo byte lido (ou, em caso de erro de leitura,
* igual ao argumento passado para o m�todo)
*/
public static byte readByte(byte defaultvalue)
{
try
{
st = getToken(); // pega os tokens a partir da linha lida
nt = st.nextToken(); // e a primeira string do token.
// retorna o valor processado pela classe Byte
return Byte.parseByte(nt);
}
catch (IOException ioe) // se houver algum erro de leitura
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de entrada e sa�da lendo um byte. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
catch (NumberFormatException nfe) // se houver algum erro de convers�o
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de convers�o de "+nt+" para um byte. "+
"Retorna "+defaultvalue);
return defaultvalue;
}
catch (NoSuchElementException nsee) // se n�o houver tokens
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Entrada n�o cont�m um byte. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
} // fim do m�todo readByte
/**
* O m�todo readShort l� e retorna um valor do tipo short.
* Este m�todo simplesmente chama o m�todo readShort com argumentos,
* descrito abaixo, considerando o valor default como sendo (short)0.
* @return o valor do tipo short lido (ou, em caso de erro de leitura,
* (short)0)
*/
public static short readShort()
{
return readShort((short)0);
} // fim do m�todo readShort
/**
* O m�todo readShort l� e retorna um valor do tipo short. Este
* m�todo tenta pegar o pr�ximo token a ser lido da entrada padr�o e o passa
* como argumento para o m�todo parseShort da classe Short, que
* tenta convert�-lo. Se a leitura e convers�o puderem ser feitas, um valor do tipo
* short � retornado, caso contr�rio o valor default (passado
* como argumento) � retornado.
* @param defaultvalue o valor default caso n�o seja poss�vel ler e
* decodificar um valor do tipo short
* @return o valor do tipo short lido (ou, em caso de erro de leitura,
* igual ao argumento passado para o m�todo)
*/
public static short readShort(short defaultvalue)
{
try
{
st = getToken(); // pega os tokens a partir da linha lida
nt = st.nextToken(); // e a primeira string do token.
// retorna o valor processado pela classe Short
return Short.parseShort(nt);
}
catch (IOException ioe) // se houver algum erro de leitura
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de entrada e sa�da lendo um short. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
catch (NumberFormatException nfe) // se houver algum erro de convers�o
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de convers�o de "+nt+" para um short. "+
"Retorna "+defaultvalue);
return defaultvalue;
}
catch (NoSuchElementException nsee) // se n�o houver tokens
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Entrada n�o cont�m um short. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
} // fim do m�todo readShort
/**
* O m�todo readInt l� e retorna um valor do tipo int. Este
* m�todo simplesmente chama o m�todo readInt com argumentos, descrito
* abaixo, considerando o valor default como sendo 0.
* @return o valor do tipo int lido (ou, em caso de erro de leitura,
* 0)
*/
public static int readInt()
{
return readInt(0);
} // fim do m�todo readInt
/**
* O m�todo readInt l� e retorna um valor do tipo int. Este
* m�todo tenta pegar o pr�ximo token a ser lido da entrada padr�o e o
* passa como argumento para o m�todo parseInt da classe Integer,
* que tenta convert�-lo. Se a leitura e convers�o puderem ser feitas, um valor
* do tipo int � retornado, caso contr�rio o valor default
* (passado como argumento) � retornado.
* @param defaultvalue o valor default caso n�o seja poss�vel ler e
* decodificar um valor do tipo int
* @return o valor do tipo int lido (ou, em caso de erro de leitura,
* igual ao argumento passado para o m�todo)
*/
public static int readInt(int defaultvalue)
{
try
{
st = getToken(); // pega os tokens a partir da linha lida
nt = st.nextToken(); // e a primeira string do token.
// retorna o valor processado pela classe Integer
return Integer.parseInt(nt);
}
catch (IOException ioe) // se houver algum erro de leitura
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de entrada e sa�da lendo um int. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
catch (NumberFormatException nfe) // se houver algum erro de convers�o
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de convers�o de "+nt+" para um int. "+
"Retorna "+defaultvalue);
return defaultvalue;
}
catch (NoSuchElementException nsee) // se n�o houver tokens
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Entrada n�o cont�m um int. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
} // fim do m�todo readInt
/**
* O m�todo readLong l� e retorna um valor do tipo long. Este
* m�todo simplesmente chama o m�todo readLong com argumentos, descrito
* abaixo, considerando o valor default como sendo 0l.
* @return o valor do tipo long lido (ou, em caso de erro de leitura,
* 0l)
*/
public static long readLong()
{
return readLong(0l);
} // fim do m�todo readLong
/**
* O m�todo readLong l� e retorna um valor do tipo long. Este
* m�todo tenta pegar o pr�ximo token a ser lido da entrada padr�o e o
* passa como argumento para o m�todo parseLong da classe Long,
* que tenta convert�-lo. Se a leitura e convers�o puderem ser feitas, um valor
* do tipo long � retornado, caso contr�rio o valor default
* (passado como argumento) � retornado.
* @param defaultvalue o valor default caso n�o seja poss�vel ler e
* decodificar um valor do tipo long
* @return o valor do tipo long lido (ou, em caso de erro de leitura,
* igual ao argumento passado para o m�todo)
*/
public static long readLong(long defaultvalue)
{
try
{
st = getToken(); // pega os tokens a partir da linha lida
nt = st.nextToken(); // e a primeira string do token.
// retorna o valor processado pela classe Long
return Long.parseLong(nt);
}
catch (IOException ioe) // se houver algum erro de leitura
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de entrada e sa�da lendo um long. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
catch (NumberFormatException nfe) // se houver algum erro de convers�o
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de convers�o de "+nt+" para um long. "+
"Retorna "+defaultvalue);
return defaultvalue;
}
catch (NoSuchElementException nsee) // se n�o houver tokens
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Entrada n�o cont�m um long. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
} // fim do m�todo readLong
/**
* O m�todo readFloat l� e retorna um valor do tipo float. Este
* m�todo simplesmente chama o m�todo readFloat com argumentos, descrito
* abaixo, considerando o valor default como sendo 0f.
* @return o valor do tipo float lido (ou, em caso de erro de leitura,
* 0f)
*/
public static float readFloat()
{
return readFloat(0f);
} // fim do m�todo readFloat
/**
* O m�todo readFloat l� e retorna um valor do tipo float. Este
* m�todo tenta pegar o pr�ximo token a ser lido da entrada padr�o e o
* analisa, verificando se aparentemente � NaN ou infinito. Se n�o for,
* passa o valor lido como argumento para o m�todo parseFloat da classe
* Float, que tenta convert�-lo. Se a leitura e convers�o puderem ser
* feitas, um valor do tipo float � retornado, caso contr�rio o valor
* default (passado como argumento) � retornado.
* @param defaultvalue o valor default caso n�o seja poss�vel ler e decodificar
* um valor do tipo float
* @return o valor do tipo float lido (ou, em caso de erro de leitura,
* igual ao argumento passado para o m�todo)
*/
public static float readFloat(float defaultvalue)
{
try
{
st = getToken(); // pega os tokens a partir da linha lida
nt = st.nextToken(); // e a primeira string do token.
// Verifica se o valor � aparentemente NaN ou infinito
if (nt.toLowerCase().startsWith("nan")) return Float.NaN;
else if (nt.toLowerCase().startsWith("inf")) return Float.POSITIVE_INFINITY;
else if (nt.toLowerCase().startsWith("+inf")) return Float.POSITIVE_INFINITY;
else if (nt.toLowerCase().startsWith("-inf")) return Float.NEGATIVE_INFINITY;
// Retorna o valor processado pela classe Float
else return Float.parseFloat(nt);
}
catch (IOException ioe) // se houver algum erro de leitura
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de entrada e sa�da lendo um float. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
catch (NumberFormatException nfe) // se houver algum erro de convers�o
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de convers�o de "+nt+" para um float. "+
"Retorna "+defaultvalue);
return defaultvalue;
}
catch (NoSuchElementException nsee) // se n�o houver tokens
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Entrada n�o cont�m um float. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
} // fim do m�todo readFloat
/**
* O m�todo readDouble l� e retorna um valor do tipo double.
* Este m�todo simplesmente chama o m�todo readDouble com argumentos,
* descrito abaixo, considerando o valor default como sendo 0.0.
* @return o valor do tipo double lido (ou, em caso de erro de leitura,
* 0.0)
*/
public static double readDouble()
{
return readDouble(0.0);
} // fim do m�todo readDouble
/**
* O m�todo readDouble l� e retorna um valor do tipo double. Este
* m�todo tenta pegar o pr�ximo token a ser lido da entrada padr�o,
* analisando o valor para ver se � NaN ou infinito, e se n�o for, usa o
* valor como argumento para o m�todo parseDouble da classe Double,
* que tenta convert�-lo. Se a leitura e convers�o puderem ser feitas, um valor
* do tipo double � retornado, caso contr�rio o valor default
* (passado como argumento) � retornado.
* @param defaultvalue o valor default caso n�o seja poss�vel ler e
* decodificar um valor do tipo double
* @return o valor do tipo double lido (ou, em caso de erro de leitura,
* igual ao argumento passado para o m�todo)
*/
public static double readDouble(double defaultvalue)
{
try
{
st = getToken(); // pega os tokens a partir da linha lida
nt = st.nextToken(); // e a primeira string do token.
// Verifica se o valor � aparentemente NaN ou infinito
if (nt.toLowerCase().startsWith("nan")) return Double.NaN;
else if (nt.toLowerCase().startsWith("inf")) return Double.POSITIVE_INFINITY;
else if (nt.toLowerCase().startsWith("+inf")) return Double.POSITIVE_INFINITY;
else if (nt.toLowerCase().startsWith("-inf")) return Double.NEGATIVE_INFINITY;
// Retorna o valor processado pela classe Double
return Double.parseDouble(nt);
}
catch (IOException ioe) // se houver algum erro de leitura
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de entrada e sa�da lendo um double. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
catch (NumberFormatException nfe) // se houver algum erro de convers�o
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de convers�o de "+nt+" para um double. "+
"Retorna "+defaultvalue);
return defaultvalue;
}
catch (NoSuchElementException nsee) // se n�o houver tokens
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Entrada n�o cont�m um double. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
} // fim do m�todo readDouble
/**
* O m�todo readChar l� e retorna um valor do tipo char. Este
* m�todo simplesmente chama o m�todo readChar com argumentos, descrito
* abaixo, considerando o valor default como sendo ' ' (espa�o).
* @return o valor do tipo char lido (ou, em caso de erro de leitura,
* espa�o)
*/
public static char readChar()
{
return readChar(' ');
} // fim do m�todo readChar
/**
* O m�todo readChar l� e retorna um valor do tipo char. Este
* m�todo tenta pegar o pr�ximo token a ser lido da entrada padr�o e retorna
* o primeiro caractere deste token, ignorando os outros. Se a leitura puder ser
* feita, um valor do tipo char � retornado, caso contr�rio o valor
* default (passado como argumento) � retornado.
* @param defaultvalue o valor default caso n�o seja poss�vel ler um valor do tipo
* char
* @return o valor do tipo char lido (ou, em caso de erro de leitura, igual ao
* argumento passado para o m�todo)
*/
public static char readChar(char defaultvalue)
{
try
{
st = getToken(); // pega os tokens a partir da linha lida
nt = st.nextToken(); // e a primeira string do token.
// retorna o primeiro caractere da string acima
return nt.charAt(0);
}
catch (IOException ioe) // se houver algum erro de leitura
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de entrada e sa�da lendo um char. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
catch (NoSuchElementException nsee) // se n�o houver tokens
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Entrada n�o cont�m um char. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
} // fim do m�todo readChar
/**
* O m�todo readString l� e retorna uma inst�ncia da classe String.
* Este m�todo simplesmente chama o m�todo readString com argumentos, descrito
* abaixo, considerando o valor default como sendo "" (string vazia).
* @return o valor da string lida (ou, em caso de erro de leitura, uma string
* vazia)
*/
public static String readString()
{
return readString("");
} // fim do m�todo readString
/**
* O m�todo readString l� e retorna uma inst�ncia da classe String.
* Este m�todo retorna uma linha inteira lida da entrada padr�o, sem process�-la como
* tokens. Se a leitura puder ser feita, a string lida � retornada, caso
* contr�rio o valor default (passado como argumento) � retornado. O valor
* default tamb�m � retornado no caso de uma string vazia.
* @param defaultvalue o valor default caso n�o seja poss�vel ler uma inst�ncia
* da classe String
* @return o valor da string lida (ou, em caso de erro de leitura, igual ao
* argumento passado para o m�todo)
*/
public static String readString(String defaultvalue)
{
try
{
nt = br.readLine(); // uma string lida diretamente
if (nt.trim().length() == 0) // nada foi entrado, ent�o
return defaultvalue; // retorna o valor default
else return nt; // retorna o que foi lido
}
catch (IOException ioe) // se houver algum erro de leitura
{
if (debug) // se for pedida a impress�o de mensagens de erro
System.err.println("KEYBOARD:: Erro de entrada e sa�da lendo uma string. "+
"Retorna "+defaultvalue);
return defaultvalue; // retorna o valor default
}
} // fim do m�todo readString
/**
* O m�todo debugOn modifica o campo que indica que mensagens de erro
* dever�o ser mostradas, fazendo com que sejam mostradas at� que o m�todo
* debugOff seja chamado.
*/
public static void debugOn()
{
debug = true;
System.err.println("KEYBOARD:: Mostrando mensagens de erro e avisos...");
} // fim do m�todo debugOn
/**
* O m�todo debugOff modifica o campo que indica que mensagens de erro
* dever�o ser mostradas, fazendo com que n�o sejam mostradas at� que o m�todo
* debugOn seja chamado.
*/
public static void debugOff()
{
debug = false;
} // fim do m�todo debugOff
} // fim da classe Keyboard
// Segue a mensagem original da classe EasyIn de Peter van der Linden
// Simple input from the keyboard for all primitive types. ver 1.0
// Copyright (c) Peter van der Linden, May 5 1997.
// corrected error message 11/21/97
//
// The creator of this software hereby gives you permission to:
// 1. copy the work without changing it
// 2. modify the work providing you send me a copy which I can
// use in any way I want, including incorporating into this work.
// 3. distribute copies of the work to the public by sale, lease,
// rental, or lending
// 4. perform the work
// 5. display the work
// 6. fold the work into a funny hat and wear it on your head.
//
// This is not thread safe, not high performance, and doesn't tell EOF.
// It's intended for low-volume easy keyboard input.
// An example of use is:
// EasyIn easy = new EasyIn();
// int i = easy.readInt(); // reads an int from System.in
// float f = easy.readFloat(); // reads a float from System.in