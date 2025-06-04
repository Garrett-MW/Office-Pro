const luhnAlgorithm = (ccNumber) => {
    const length = ccNumber.length;

    if(length % 2 == 0)
    {
        /** Traverse the whole credit card number.
         *  Starts at the beginning of the number and begins doubling from the first number.
         */
        for(let i = 0; i < length; i++)
        {
            let currentDigit = parseInt(ccNumber[i]);
            if (i % 2 == 0) // I only want to double every other number, starts doubling with the second-to-last number. I don't want to double the last number.
            {
                if ((currentDigit *= 2) > 9)
                {
                    // Separate the number into component parts and then add them together.
                    let trailingNumber = currentDigit % 10;
                    let firstNumber = parseInt(currentDigit / 10);

                    currentDigit = firstNumber + trailingNumber;
                }
            }
        }
    }
    else {
        /** Traverse the whole credit card number.
         *  Starts at the end of the number and begins doubling from the second-to-last number. This fixes the case for odd-numbered length credit card numbers, like AMEX cards.
         */
        for(let i = length - 1 ; i >= 0; i--)
        {
            let currentDigit = parseInt(ccNumber[i]);
            if ((i - 1) % 2 == 0) // I only want to double every other number, starts doubling with the second-to-last number. I don't want to double the last number.
            {
                if ((currentDigit *= 2) > 9)
                {
                    // Separate the number into component parts and then add them together.
                    let trailingNumber = currentDigit % 10;
                    let firstNumber = parseInt(currentDigit / 10);

                    currentDigit = firstNumber + trailingNumber;
                }
            }


        }
    }
}

const checkCC = () => {
    const elCCNumber = document.getElementById('credit');
    const elCCValidation = document.getElementById('buttonCheckout');
    let message = "";

    // Calls the Luhn algorithm. Fails if the Luhn algorithm returns false.
    if( luhnAlgorithm(elCCNumber.value) ){
        message = "Well, it looks like that worked! Your CC is valid!";
        elCCValidation.textContent = message; // Show valid message
        return true;
    }else{
        message = "CC verification failed :(";
        elCCValidation.textContent = message; // Show valid message
        return false;
    }
};

document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('#checkoutForm');
    form.addEventListener('submit', (event) => {
        event.preventDefault(); // Prevent form from submitting initially
        
        // Perform validation
        if (checkCC()) {
            form.submit(); // Only submit if validation passes
        } else {
            console.log('Credit card validation failed. Form not submitted.');
        }
    });
});
