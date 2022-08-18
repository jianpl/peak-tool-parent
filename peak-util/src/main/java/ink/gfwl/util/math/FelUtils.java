package ink.gfwl.util.math;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Fel公式计算
 * @author jianpòlan
 * @version 1.0
 **/
public final class FelUtils {

    /**
     * 公式计算
     * @param params 参数
     * @param formula 公式
     * @return 计算结果
     */
    public static Object eval(ConcurrentHashMap<String, Object> params, String formula){
        FelEngine fel = new FelEngineImpl();
        FelContext context = fel.getContext();
        params.forEach(context::set);
        return BigDecimal.valueOf(Double.parseDouble(fel.eval(formula) + "")).setScale(2, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        // 计算平均值
        ConcurrentHashMap<String, Object> params = new ConcurrentHashMap<>();

        HashMap<String, Object> y2021 = new HashMap<>();
        y2021.put("sum", 700d);
        HashMap<String, Object> y2022 = new HashMap<>();
        y2022.put("sum", 300d);
        params.put("h2021", y2021);
        params.put("y2022", y2022);

        System.out.println("两年平均值："+eval(params, "(h2021.sum + y2022.sum)/2"));
    }

}
