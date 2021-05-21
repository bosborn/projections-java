package mil.nga.proj.crs.operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import mil.nga.proj.crs.common.Identifier;
import mil.nga.proj.crs.wkt.CRSWriter;

/**
 * Operation Parameter File
 * 
 * @author osbornb
 */
public class OperationParameterFile implements Parameter {

	/**
	 * Logger
	 */
	private static final Logger logger = Logger
			.getLogger(OperationParameterFile.class.getName());

	/**
	 * Name
	 */
	private String name = null;

	/**
	 * Name
	 */
	private String fileName = null;

	/**
	 * Identifiers
	 */
	private List<Identifier> identifiers = null;

	/**
	 * Constructor
	 */
	public OperationParameterFile() {

	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            name
	 * @param fileName
	 *            file name
	 */
	public OperationParameterFile(String name, String fileName) {
		setName(name);
		setFileName(fileName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ParameterType getParameterType() {
		return ParameterType.PARAMETER_FILE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the file name
	 * 
	 * @return file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Set the file name
	 * 
	 * @param fileName
	 *            file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Identifier> getIdentifiers() {
		return identifiers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasIdentifiers() {
		return identifiers != null && !identifiers.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int numIdentifiers() {
		return identifiers != null ? identifiers.size() : 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identifier getIdentifier(int index) {
		return identifiers.get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setIdentifiers(List<Identifier> identifiers) {
		this.identifiers = identifiers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addIdentifier(Identifier identifier) {
		if (this.identifiers == null) {
			this.identifiers = new ArrayList<>();
		}
		this.identifiers.add(identifier);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addIdentifiers(List<Identifier> identifiers) {
		if (this.identifiers == null) {
			this.identifiers = new ArrayList<>();
		}
		this.identifiers.addAll(identifiers);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result
				+ ((identifiers == null) ? 0 : identifiers.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperationParameterFile other = (OperationParameterFile) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (identifiers == null) {
			if (other.identifiers != null)
				return false;
		} else if (!identifiers.equals(other.identifiers))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		String value = null;
		CRSWriter writer = new CRSWriter();
		try {
			writer.write(this);
			value = writer.toString();
		} catch (IOException e) {
			logger.log(Level.WARNING,
					"Failed to write parameter file as a string", e);
			value = super.toString();
		} finally {
			writer.close();
		}
		return value;
	}

}
