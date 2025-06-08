import { AbstractControl, ValidationErrors } from '@angular/forms';

export function decimalValidator(
  control: AbstractControl
): ValidationErrors | null {
  const value = control.value;

  if (value === null || value === undefined || value === '') {
    return { decimalInvalid: true };
  }

  const valueStr = String(value).trim();
  const regex = /^\d+(\.\d{1,2})?$/;

  if (!regex.test(valueStr)) {
    return { decimalInvalid: true };
  }

  return null;
}

export function decimalOptionalValidator(
  control: AbstractControl
): ValidationErrors | null {
  const value = control.value;

  if (value === null || value === undefined || value === '') {
    return null;
  }

  const valueStr = String(value).trim();
  const regex = /^\d+(\.\d{1,2})?$/;

  if (!regex.test(valueStr)) {
    return { decimalInvalid: true };
  }

  return null;
}
