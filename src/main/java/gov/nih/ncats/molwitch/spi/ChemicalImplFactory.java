/*
 * NCATS-MOLWITCH
 *
 * Copyright 2025 NIH/NCATS
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package gov.nih.ncats.molwitch.spi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import gov.nih.ncats.common.io.InputStreamSupplier;

/**
 * Factory class to create {@link ChemicalImpl}s instances.
 * 
 * @author katzelda
 *
 */
public interface ChemicalImplFactory {
	/**
	 * Create a {@link ChemicalImpl} from the given SMILES string.
	 * 
	 * @param smiles the SMILES string, will never be null.
	 * 
	 * @return a new {@link ChemicalImpl}, will never be null.
	 * 
	 * @throws IOException if there is a problem parsing the SMILES.
	 */
	ChemicalImpl createFromSmiles(String smiles) throws IOException;

	/**
	 * Create a {@link ChemicalImpl} from the given SMILES string.
	 *  @param format the format the data is in.
	 *
	 * @param input the data to parse string, will never be null.
	 *
	 * @return a new {@link ChemicalImpl}, will never be null.
	 *
	 * @throws IOException if there is a problem parsing the SMILES.
	 */
	ChemicalImpl createFromString(String format, String input) throws IOException;
	/**
	 * Parse the given data as bytes and create all the {@link ChemicalImpl}s encoded inside it.
	 * This could be bytes from a file or bytes from a String encoding.
	 * If it's from a file, the file format is not provided so it could be any of the
	 * standard cheminformatics file formats.
	 * 
	 * @param bytes the byte array to parse.
	 * @param start the start offset into the array to start parsing; may be {@code 0}.
	 * @param length the number of bytes to read from the array.
	 * 
	 * 
	 * @return a List of {@link ChemicalImpl}, will never be null, and shouldn't be empty.
	 * 
	 * @throws IOException if there is a problem parsing the bytes.
	 */
	ChemicalImplReader create(byte[] bytes, int start, int length) throws IOException;
	/**
	 * Parse the given data as bytes and create all the {@link ChemicalImpl}s encoded inside it.
	 * This could be bytes from a file or bytes from a String encoding.
	 * If it's from a file, the file format is not provided so it could be any of the
	 * standard cheminformatics file formats.
	 *  @param format the format the file is encoded in.
	 * @param bytes the byte array to parse.
	 * @param start the start offset into the array to start parsing; may be {@code 0}.
	 * @param length the number of bytes to read from the array.
	 *
	 *
	 * @return a List of {@link ChemicalImpl}, will never be null, and shouldn't be empty.
	 *
	 * @throws IOException if there is a problem parsing the bytes.
	 *
	 * @since 0.6.0
	 */
	ChemicalImplReader create(String format, byte[] bytes, int start, int length) throws IOException;
	/**
	 * Parse the given String and create all the {@link ChemicalImpl}s encoded inside it.
	 *  @param format the format the file is encoded in.
	 * @param input the String to parse.

	 *
	 *
	 * @return a List of {@link ChemicalImpl}, will never be null, and shouldn't be empty.
	 *
	 * @throws IOException if there is a problem parsing the bytes.
	 *
	 * @since 0.6.0
	 */
	ChemicalImplReader create(String format, String input) throws IOException;
	/**
	 * Parse the given file and create all the {@link ChemicalImpl}s encoded inside it.
	 * The file format of the file is not provided so it could be any of the
	 * standard cheminformatics file formats.
	 * 
	 * @param file the {@link File} to parse.
	 * 
	 * @return a List of {@link ChemicalImpl}, will never be null, and shouldn't be empty.
	 * 
	 * @throws IOException if there is a problem parsing the file.
	 */
	ChemicalImplReader create(File file) throws IOException;
	/**
	 * Parse the given {@link InputStream} and create all the {@link ChemicalImpl}s encoded inside it.
	 * The file format of the streamed file is not provided so it could be any of the
	 * standard cheminformatics file formats.
	 * 
	 * @param format the format the file is encoded in.
	 * 
	 * @param in the {@link InputStream} to parse.
	 * 
	 * @return a List of {@link ChemicalImpl}, will never be null, and shouldn't be empty.
	 * 
	 * @throws IOException if there is a problem parsing the InputStream.
	 */
	ChemicalImplReader create(String format, InputStream in) throws IOException;
	
	/**
	 * Parse the given file and create all the {@link ChemicalImpl}s encoded inside it.
	 * The file format of the file is not provided so it could be any of the
	 * standard cheminformatics file formats.
	 * 
	 * @param format the format the file is encoded in.
	 * 
	 * @param file the {@link File} to parse.
	 * 
	 * @return a List of {@link ChemicalImpl}, will never be null, and shouldn't be empty.
	 * 
	 * @throws IOException if there is a problem parsing the file.
	 */
	ChemicalImplReader create(String format, File file) throws IOException;
	
	/**
	 * Parse the given {@link InputStreamSupplier} and create all the {@link ChemicalImpl}s encoded inside it.
	 * 
	 * 
	 * @param format the format the file is encoded in.
	 * 
	 * @param in the {@link InputStreamSupplier} to parse.
	 * 
	 * @return a List of {@link ChemicalImpl}, will never be null, and shouldn't be empty.
	 * 
	 * @throws IOException if there is a problem parsing the InputStream.
	 */
	ChemicalImplReader create(String format, InputStreamSupplier in) throws IOException;
	
	/**
	 * Parse the given {@link InputStreamSupplier} and create all the {@link ChemicalImpl}s encoded inside it.
	 * The file format of the streamed file is not provided so it could be any of the
	 * standard cheminformatics file formats.
	 * 
	 * @param in the {@link InputStreamSupplier} to parse.
	 * 
	 * @return a List of {@link ChemicalImpl}, will never be null, and shouldn't be empty.
	 * 
	 * @throws IOException if there is a problem parsing the InputStream.
	 */
	ChemicalImplReader create(InputStreamSupplier in) throws IOException;
	/**
	 * Parse the given {@link InputStream} and create all the {@link ChemicalImpl}s encoded inside it.
	 * The file format of the streamed file is not provided so it could be any of the
	 * standard cheminformatics file formats.
	 * 
	 * @param in the {@link InputStream} to parse.
	 * 
	 * @return a List of {@link ChemicalImpl}, will never be null, and shouldn't be empty.
	 * 
	 * @throws IOException if there is a problem parsing the InputStream.
	 */
	ChemicalImplReader create(InputStream in) throws IOException;
	/**
	 * Parse the given {@link InputStream} and create all the {@link ChemicalImpl}s encoded inside it.
	 * The file format of the streamed file is not provided so it could be any of the
	 * standard cheminformatics file formats.
	 *
	 * @param in the {@link InputStream} to parse.
	 * @param in the {@link String} to parse.
	 *
	 * @return a List of {@link ChemicalImpl}, will never be null, and shouldn't be empty.
	 *
	 * @throws IOException if there is a problem parsing the InputStream.
	 */
	ChemicalImplReader create(InputStream in, String encoding) throws IOException;
	/**
	 * Create a new {@link ChemicalImpl} object
	 * that is doesn't have any atoms
	 * or bonds.  Clients can then
	 * add atoms and bonds later.
	 * 
	 * @return a new {@link ChemicalImpl} object;
	 * will never be null.
	 */
	ChemicalImpl createNewEmptyChemical();
	boolean supports(String format);
	ChemicalImpl createFromSmarts(String smarts) throws IOException;
	boolean isDefault();

    ChemicalImpl create(String unknownFormattedInput) throws IOException;

    /**
     * This factory can support multiple (hopefully every) format not just a particular type.
     * Ideally this factory has it's own way of detecting the format of the chemical objects to read
     * or the parser implementation supports multiple formats.
     * @return {@code true} if this factory is format agnostic; {@code false} otherwise.
     *
     * @since 0.5.2
     */
    boolean isFormatAgnostic();

	default void applyParameters(Map<String, Object> params) {
		//default does nothing; individual implementations _can_ do something
	}
}
