package fr.xlim.ssd.capmanipulator.bcel.utils;

import fr.xlim.ssd.capmanipulator.bcel.exceptions.SignatureFormatException;
import fr.xlim.ssd.capmanipulator.library.TypeDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mentalow
 */
public class TypeDescriptorConverter {

    private TypeDescriptor td;
    private List<Character> signatureElements;
    private List<String> stringSignatureElements;
    private String stringRet;

    public TypeDescriptorConverter(TypeDescriptor td) {

        this.td = td;
        signatureElements = new ArrayList<Character>();
        stringRet = "Reference = ";

        stringSignatureElements = new ArrayList<String>();
    }


    public String toString() {

        String buffer;

        for (Byte doubleNibble : td.getType()) {

            NibbleHandler nibbleHandler = new NibbleHandler(doubleNibble);

            signatureElements.addAll(nibbleHandler.toCharArray());
        }

        for (int i=0; i < signatureElements.size(); i++) {

            switch (signatureElements.get(i).charValue()) {

                case '0':           /* padding */

                    break;
                case '1':           /* void */
                    stringSignatureElements.add("V");
                    break;
                case '2':           /* boolean */
                    stringSignatureElements.add("Z");
                    break;
                case '3':           /* byte */
                    stringSignatureElements.add("B");
                    break;
                case '4':           /* short */
                    stringSignatureElements.add("S");
                    break;
                case '5':           /* int */
                    stringSignatureElements.add("I");
                    break;
                case '6':           /* reference */
                    buffer = "";

                    buffer += signatureElements.get(++i).toString();     /* package token left half */
                    buffer += signatureElements.get(++i).toString();     /* package token right half */
                    buffer += "/";
                    buffer += signatureElements.get(++i).toString();     /* class token left half */
                    buffer += signatureElements.get(++i).toString();     /* class token right half */

                    buffer += ";";

                    stringSignatureElements.add(buffer);
                    break;
                case 'a':           /* array of boolean */
                    stringSignatureElements.add("[Z");
                    break;
                case 'b':           /* array of byte */
                    stringSignatureElements.add("[B");
                    break;
                case 'c':           /* array of short */
                    stringSignatureElements.add("[S");
                    break;
                case 'd':           /* array of int */
                    stringSignatureElements.add("[I");
                    break;
                case 'e':           /* array of reference */
                    buffer = "";

                    buffer += signatureElements.get(++i).toString();     /* package token left half */
                    buffer += signatureElements.get(++i).toString();     /* package token right half */
                    buffer += "/";
                    buffer += signatureElements.get(++i).toString();     /* class token left half */
                    buffer += signatureElements.get(++i).toString();     /* class token right half */

                    stringSignatureElements.add(buffer);
                    break;
                default:
                    try {
                        throw new SignatureFormatException("Unknown type \"" + signatureElements.get(i));
                    } catch (SignatureFormatException e) {
                        e.printStackTrace();
                    }
            }
        }

        convertSignature();

        return stringRet;
    }

    private void convertSignature() {

        for (int i=0; i < stringSignatureElements.size(); i++) {

            stringRet += stringSignatureElements.get(i);

        }
    }
}