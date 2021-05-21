package mil.nga.proj.crs.common;

import java.util.List;

/**
 * Interface Scope, Extent, Identifier, and Remark values
 * 
 * @author osbornb
 */
public interface ScopeExtentIdentifierRemark extends Identifiable {

	/**
	 * Get the usages
	 * 
	 * @return usages
	 */
	public List<Usage> getUsages();

	/**
	 * Has usages
	 * 
	 * @return true if has usages
	 */
	public boolean hasUsages();

	/**
	 * Number of usages
	 * 
	 * @return usages count
	 */
	public int numUsages();

	/**
	 * Get the usage at the index
	 * 
	 * @param index
	 *            usage index
	 * @return usage
	 */
	public Usage getUsage(int index);

	/**
	 * Set the usages
	 * 
	 * @param usages
	 *            usages
	 */
	public void setUsages(List<Usage> usages);

	/**
	 * Add the usage
	 * 
	 * @param usage
	 *            usage
	 */
	public void addUsage(Usage usage);

	/**
	 * Add the usages
	 * 
	 * @param usages
	 *            usages
	 */
	public void addUsages(List<Usage> usages);

	/**
	 * Get the remark
	 * 
	 * @return remark
	 */
	public String getRemark();

	/**
	 * Has remark
	 * 
	 * @return true if has remark
	 */
	public boolean hasRemark();

	/**
	 * Set the remark
	 * 
	 * @param remark
	 *            remark
	 */
	public void setRemark(String remark);

}
