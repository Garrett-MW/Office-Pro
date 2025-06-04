
const luhnAlgorithm = (ccNumber) => {
    const length = ccNumber.length;
    let sum = 0;
    let shouldDouble = false;

    for (let i = length - 1; i >= 0; i--) {
        let currentDigit = parseInt(ccNumber[i]);

        if (shouldDouble) {
            currentDigit *= 2;
            if (currentDigit > 9) {
                currentDigit = currentDigit - 9; // Sum the digits of numbers over 9
            }
        }

        sum += currentDigit;
        shouldDouble = !shouldDouble; // Toggle the doubling flag
    }

    return sum % 10 === 0; // Return true if valid
};

const checkCC = () => {
    const elCCNumber = document.getElementById('credit');
    const elCCValidation = document.getElementById('buttonCheckout');
    let message = "";

    if (luhnAlgorithm(elCCNumber.value)) {
        message = "Well, it looks like that worked! Your CC is valid!";
        elCCValidation.textContent = message; // Show valid message
        return true; // Return true for form submission
    } else {
        message = "CC verification failed :(";
        elCCValidation.textContent = message; // Show invalid message
        return false; // Return false to prevent form submission
    }
};

// Add event listener to the form
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