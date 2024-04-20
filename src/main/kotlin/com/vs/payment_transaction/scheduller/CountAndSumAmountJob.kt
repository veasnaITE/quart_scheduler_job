package com.vs.payment_transaction.scheduller
import com.vs.payment_transaction.repository.PaymentTranRepository
import com.vs.payment_transaction.repository.TempCountRepository
import org.quartz.Job
import org.quartz.JobExecutionContext
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CountAndSumAmountJob(
    private val paymentTranRepository: PaymentTranRepository,
    private val tempCountRepository: TempCountRepository
) : Job {

    @Transactional
    override fun execute(context: JobExecutionContext) {
         println(context.jobDetail.key.name)
//        val counting = paymentTranRepository.countUserIdGroupByMerchant()
//        counting.map { tempCount -> tempCountRepository.save(tempCount) }
    }
}