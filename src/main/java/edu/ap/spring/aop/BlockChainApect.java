package edu.ap.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.*;

import edu.ap.spring.service.Wallet;
import edu.ap.spring.transaction.Transaction;

@Component
@Aspect
public class BlockChainApect {

    @Around("execution(public * sendFunds(..))")
    public Transaction checkBalance(ProceedingJoinPoint joinPoint) throws Throwable{

        Wallet wallet = (Wallet) joinPoint.getTarget();
        Object[] args = joinPoint.getArgs();
        float value = (float) args[1];
        float balance = wallet.getBalance();

        if(balance < value){
            System.out.println(" # Not enough funds to send transaction. Transaction cancelled.");
            throw new Exception();
        }

        Transaction result = (Transaction) joinPoint.proceed();
        
        return result;
    }
}
