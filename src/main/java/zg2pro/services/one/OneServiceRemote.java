package zg2pro.services.one;

import zg2pro.services.PermissionCheckAnnotation;
import zg2pro.services.PermissionEnum;

/**
 *
 * @author zg2pro
 */
public interface OneServiceRemote {

    @PermissionCheckAnnotation(PermissionEnum.CAN_DO_ONE)
    boolean exampleMethod(String dummyArg);

}
