package libPurple;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class PIDGetEncoder implements PIDSource{

	private Encoder3075 encoder;
	private boolean returnRate;
	
	public PIDGetEncoder(Encoder3075 e, boolean returnRate)
	{
		encoder = e;
		this.returnRate = returnRate;
	}
	
	@Override
	public double pidGet() {
		
		return returnRate ? encoder.getRate() : encoder.getDistance();
	}

	@Override
	// TODO complete this fuck
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return returnRate ? PIDSourceType.kRate : PIDSourceType.kDisplacement;
//		return PIDSourceType.kDisplacement;
	}
	
	public Encoder3075 getEncoder()
	{
		return encoder;
	}
	
	public void setReturnRate(boolean b)
	{
		returnRate = b;
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub
	}
	
	
}
