import { InjectionToken } from '@angular/core';

export interface Config {
  url: string;
  user: string;
}

export const APP_CONFIG: Config = {
  url: 'https://www.google.com.ar',
  user: 'lucasm'
}

export const CONFIG = new InjectionToken<Config>('config');

