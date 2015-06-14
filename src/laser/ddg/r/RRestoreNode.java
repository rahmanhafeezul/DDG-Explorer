package laser.ddg.r;

import laser.ddg.ProvenanceData;

/**
 * Creates a node that represents a restore operation where the state of
 * the environment is restored from a checkpoint file.
 * 
 * @author Barbara Lerner
 * @version December 24, 2013
 *
 */
public class RRestoreNode extends RFunctionInstanceNode {

	/**
	 * Creates the node
	 * @param name node name
	 * @param provData the ddg
	 */
	public RRestoreNode(String name, ProvenanceData provData) {
		super(name, null, provData);
	}

	/**
	 * States whether or not the node can be a root
	 * @return false - LeafNode so cannot be root
	 */
	@Override
	public boolean canBeRoot() {
		return false;
	}

	/**
	 * Returns the type of the node
	 * 
	 * @return "Restore"
	 */
	@Override
	public String getType() {
		return "Restore";
	}

}